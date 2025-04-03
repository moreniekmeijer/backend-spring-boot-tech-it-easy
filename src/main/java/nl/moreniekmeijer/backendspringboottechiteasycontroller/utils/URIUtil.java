package nl.moreniekmeijer.backendspringboottechiteasycontroller.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class URIUtil {

    public static URI createResourceUri(Long resourceId) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resourceId)
                .toUri();
    }

    public static URI createUserUri(String username) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(username)
                .toUri();
    }
}