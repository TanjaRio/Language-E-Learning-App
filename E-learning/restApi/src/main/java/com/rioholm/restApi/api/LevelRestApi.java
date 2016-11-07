package com.rioholm.restApi.api;

import io.swagger.annotations.Api;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Api(value = "/level" , description = "Handling of creating and retrieving levels")
@Path("/level")
@Produces({
        Formats.V1_NEWS_JSON, //custom Json with versioning
        Formats.BASE_JSON //old format
})
public interface LevelRestApi {
}
