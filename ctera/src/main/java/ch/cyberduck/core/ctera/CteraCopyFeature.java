package ch.cyberduck.core.ctera;

/*
 * Copyright (c) 2002-2024 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.Path;
import ch.cyberduck.core.dav.DAVCopyFeature;
import ch.cyberduck.core.exception.BackgroundException;

import java.util.Optional;

import static ch.cyberduck.core.ctera.CteraAttributesFinderFeature.*;

public class CteraCopyFeature extends DAVCopyFeature {

    public CteraCopyFeature(final CteraSession session) {
        super(session);
    }

    @Override
    public void preflight(final Path source, final Optional<Path> optional) throws BackgroundException {
        if(optional.isPresent()) {
            final Path target = optional.get();
            // defaults to Acl.EMPTY (disabling role checking) if target does not exist
            assumeRole(target, WRITEPERMISSION);
            // no createfilespermission required for now
            if(source.isDirectory()) {
                assumeRole(target.getParent(), target.getName(), CREATEDIRECTORIESPERMISSION);
            }
        }
    }
}
