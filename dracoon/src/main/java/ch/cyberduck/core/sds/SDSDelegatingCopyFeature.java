package ch.cyberduck.core.sds;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.ConnectionCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Copy;
import ch.cyberduck.core.io.StreamListener;
import ch.cyberduck.core.shared.DefaultCopyFeature;
import ch.cyberduck.core.transfer.TransferStatus;

import java.util.EnumSet;
import java.util.Optional;

public class SDSDelegatingCopyFeature implements Copy {

    private final SDSSession session;
    private final SDSNodeIdProvider nodeid;
    private final SDSCopyFeature proxy;
    private final DefaultCopyFeature copy;

    private final PathContainerService containerService
            = new SDSPathContainerService();

    public SDSDelegatingCopyFeature(final SDSSession session, final SDSNodeIdProvider nodeid, final SDSCopyFeature proxy) {
        this.session = session;
        this.nodeid = nodeid;
        this.proxy = proxy;
        this.copy = new DefaultCopyFeature(session);
    }

    @Override
    public Path copy(final Path source, final Path target, final TransferStatus status, final ConnectionCallback callback, final StreamListener listener) throws BackgroundException {
        if(proxy.isSupported(source, Optional.of(target))) {
            return proxy.copy(source, target, status, callback, listener);
        }
        // Copy between encrypted and unencrypted data room
        if(new SDSTripleCryptEncryptorFeature(session, nodeid).isEncrypted(containerService.getContainer(target))) {
            // File key must be set for new upload
            status.setFilekey(SDSTripleCryptEncryptorFeature.generateFileKey());
        }
        final Path result = copy.copy(source, target, status, callback, listener);
        nodeid.cache(target, null);
        return new Path(result).withAttributes(new SDSAttributesFinderFeature(session, nodeid).find(result));
    }

    @Override
    public void preflight(final Path source, final Optional<Path> target) throws BackgroundException {
        if(proxy.isSupported(source, target)) {
            proxy.preflight(source, target);
        }
        else {
            copy.preflight(source, target);
        }
    }

    @Override
    public EnumSet<Flags> features(final Path source, final Path target) {
        return proxy.features(source, target);
    }
}
