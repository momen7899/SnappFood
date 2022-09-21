package com.momen.food.common;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;
import java.util.Collections;

public class KeyClockManager {

    public void saveUserInKeyClock(String userName) {
        String serverUrl = "http://localhost:8080/realms/foodrealm/broker/oidc/endpoint";
        String realm = "foodrealm";
        String clientId = "foodclient";
        String clientSecret = "eM186Xw3hLYQEtCPFW7th9rraxY2RoLo";

        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .grantType(OAuth2Constants.PASSWORD)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .username("admin")
                .password("admin")
                .scope("openid")
                .build();

        // Define user
        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(userName);

        // Get realm
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource userResource = realmResource.users();

        // Create user (requires manage-users role)
        Response response = userResource.create(user);
        System.out.println("Response: " + response.getStatusInfo());
        System.out.println(response.getLocation());
        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");

        System.out.printf("User created with userId: %s%n", userId);

        // Get realm role "tester" (requires view-realm role)
        RoleRepresentation testerRealmRole = realmResource.roles()//
                .get("tester").toRepresentation();

        // Assign realm role tester to user
        userResource.get(userId).roles().realmLevel() //
                .add(Collections.singletonList(testerRealmRole));

        // Get client
        ClientRepresentation app1Client = realmResource.clients() //
                .findByClientId("app-javaee-petclinic").get(0);

        // Get client level role (requires view-clients role)
        RoleRepresentation userClientRole = realmResource.clients().get(app1Client.getId()) //
                .roles().get("user").toRepresentation();

        // Assign client level role to user
        userResource.get(userId).roles() //
                .clientLevel(app1Client.getId()).add(Collections.singletonList(userClientRole));

        // Define password credential
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue("test");

        // Set password credential
        userResource.get(userId).resetPassword(passwordCred);

    }
}
