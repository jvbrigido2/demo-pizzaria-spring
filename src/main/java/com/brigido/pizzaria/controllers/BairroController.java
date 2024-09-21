package com.brigido.pizzaria.controllers;

import com.brigido.pizzaria.dtos.BairroResponse;
import com.brigido.pizzaria.dtos.CreateBairroRequest;
import com.brigido.pizzaria.dtos.UpdateBairroRequest;
import com.brigido.pizzaria.exceptions.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name="BairroController", description = "Controller responsible for bairro operations")
@RequestMapping("api/bairros")
public interface BairroController {

    @Operation(summary = "Find all bairros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users found",
            content = @Content(
                    mediaType = APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = BairroResponse.class))
            )),
            @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content(
                    mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = StandardError.class)
            ))
    })
    @GetMapping
    public ResponseEntity<List<BairroResponse>> findALl();

    @Operation(summary = "Save a new bairro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bairro created"),
            @ApiResponse(
                    responseCode = "400", description = "Bad request",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StandardError.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StandardError.class)
                    ))
    })
    @PostMapping
    public ResponseEntity<Void> createBairro(@Valid @RequestBody final CreateBairroRequest request);

    @Operation(summary = "Find bairro by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bairro Found"),
            @ApiResponse(
                    responseCode = "404", description = "Bairro not found",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StandardError.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StandardError.class)
                    ))
    })
    @GetMapping("/bairro")
    public ResponseEntity<BairroResponse> getBairroByName(@RequestParam final String name);

    @Operation(summary = "Delete bairro by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Bairro deleted"),
            @ApiResponse(
                    responseCode = "404", description = "Bairro not found",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StandardError.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = StandardError.class)
                    ))
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBairroById(@PathVariable(name = "id") final String id);

    @Operation(summary = "Update a bairro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated",
                    content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = BairroResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))
            ),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<BairroResponse> updateBairro(
            @PathVariable(name="id") final String id,
            @Valid @RequestBody final UpdateBairroRequest request
    );
}
