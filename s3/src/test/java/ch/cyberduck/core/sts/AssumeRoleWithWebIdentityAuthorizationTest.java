package ch.cyberduck.core.sts;

/*
 * Copyright (c) 2002-2023 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.DisabledCancelCallback;
import ch.cyberduck.core.DisabledConnectionCallback;
import ch.cyberduck.core.DisabledHostKeyCallback;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Protocol;
import ch.cyberduck.core.ProtocolFactory;
import ch.cyberduck.core.exception.AccessDeniedException;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.proxy.DisabledProxyFinder;
import ch.cyberduck.core.s3.S3AccessControlListFeature;
import ch.cyberduck.core.s3.S3DefaultDeleteFeature;
import ch.cyberduck.core.s3.S3FindFeature;
import ch.cyberduck.core.s3.S3Protocol;
import ch.cyberduck.core.s3.S3ReadFeature;
import ch.cyberduck.core.s3.S3Session;
import ch.cyberduck.core.s3.S3TouchFeature;
import ch.cyberduck.core.serializer.impl.dd.ProfilePlistReader;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.TestcontainerTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

import static org.junit.Assert.*;

@Category(TestcontainerTest.class)
public class AssumeRoleWithWebIdentityAuthorizationTest extends AbstractAssumeRoleWithWebIdentityTest {

    @Test
    public void testAuthorizationFindBucket() throws BackgroundException {
        final Protocol profile = new ProfilePlistReader(new ProtocolFactory(new HashSet<>(Collections.singleton(new S3Protocol())))).read(
                AbstractAssumeRoleWithWebIdentityTest.class.getResourceAsStream("/S3 (OIDC).cyberduckprofile"));
        final Host host = new Host(profile, profile.getDefaultHostname(), new Credentials("rawuser", "rawuser"));
        final S3Session session = new S3Session(host);
        session.open(new DisabledProxyFinder(), new DisabledHostKeyCallback(), new DisabledLoginCallback(), new DisabledCancelCallback());
        session.login(new DisabledLoginCallback(), new DisabledCancelCallback());
        final Path container = new Path("cyberduckbucket", EnumSet.of(Path.Type.directory, Path.Type.volume));
        assertTrue(new S3FindFeature(session, new S3AccessControlListFeature(session)).find(container));
        session.close();
    }

    @Test
    public void testAuthorizationUserReadAccessOnBucket() throws BackgroundException {
        final Protocol profile = new ProfilePlistReader(new ProtocolFactory(new HashSet<>(Collections.singleton(new S3Protocol())))).read(
                AbstractAssumeRoleWithWebIdentityTest.class.getResourceAsStream("/S3 (OIDC).cyberduckprofile"));
        final Host host = new Host(profile, profile.getDefaultHostname(), new Credentials("rouser", "rouser"));
        final S3Session session = new S3Session(host);
        session.open(new DisabledProxyFinder(), new DisabledHostKeyCallback(), new DisabledLoginCallback(), new DisabledCancelCallback());
        session.login(new DisabledLoginCallback(), new DisabledCancelCallback());
        final TransferStatus status = new TransferStatus();
        final Path container = new Path("cyberduckbucket", EnumSet.of(Path.Type.directory, Path.Type.volume));
        new S3ReadFeature(session).read(new Path(container, "testfile.txt", EnumSet.of(Path.Type.file)), status, new DisabledConnectionCallback());
        session.close();
    }

    @Test
    public void testAuthorizationWritePermissionOnBucket() throws BackgroundException {
        final Protocol profile = new ProfilePlistReader(new ProtocolFactory(new HashSet<>(Collections.singleton(new S3Protocol())))).read(
                AbstractAssumeRoleWithWebIdentityTest.class.getResourceAsStream("/S3 (OIDC).cyberduckprofile"));
        final Host host = new Host(profile, profile.getDefaultHostname(), new Credentials("rawuser", "rawuser"));
        final S3Session session = new S3Session(host);
        session.open(new DisabledProxyFinder(), new DisabledHostKeyCallback(), new DisabledLoginCallback(), new DisabledCancelCallback());
        session.login(new DisabledLoginCallback(), new DisabledCancelCallback());
        final Path container = new Path("cyberduckbucket", EnumSet.of(Path.Type.directory, Path.Type.volume));
        final Path test = new Path(container, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        final S3AccessControlListFeature acl = new S3AccessControlListFeature(session);
        new S3TouchFeature(session, acl).touch(test, new TransferStatus());
        assertTrue(new S3FindFeature(session, acl).find(test));
        new S3DefaultDeleteFeature(session, acl).delete(Collections.singletonList(test), new DisabledLoginCallback(), new Delete.DisabledCallback());
        assertFalse(new S3FindFeature(session, acl).find(test));
        session.close();
    }

    @Test
    public void testAuthorizationNoWritePermissionOnBucket() throws BackgroundException {
        final Protocol profile = new ProfilePlistReader(new ProtocolFactory(new HashSet<>(Collections.singleton(new S3Protocol())))).read(
                AbstractAssumeRoleWithWebIdentityTest.class.getResourceAsStream("/S3 (OIDC).cyberduckprofile"));
        final Host host = new Host(profile, profile.getDefaultHostname(), new Credentials("rouser", "rouser"));
        final S3Session session = new S3Session(host);
        session.open(new DisabledProxyFinder(), new DisabledHostKeyCallback(), new DisabledLoginCallback(), new DisabledCancelCallback());
        session.login(new DisabledLoginCallback(), new DisabledCancelCallback());
        final Path container = new Path("cyberduckbucket", EnumSet.of(Path.Type.directory, Path.Type.volume));
        final Path test = new Path(container, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        assertThrows(AccessDeniedException.class, () -> new S3TouchFeature(session, new S3AccessControlListFeature(session)).touch(test, new TransferStatus()));
        assertFalse(new S3FindFeature(session, new S3AccessControlListFeature(session)).find(test));
        session.close();
    }
}