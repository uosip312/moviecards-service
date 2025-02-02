/**
 * Autora: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 * Cambios: José R. Hilera (2024) para eliminar la parte cliente de la aplicación original
 */

package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.service.actor.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    ActorService actorService;
    
    @GetMapping("/actors")
    public List<Actor> getActorsList() {
        return (actorService.getAllActors());
    }

    @PostMapping("/actors")
    public void newActor(@RequestBody Actor actor) {
        actorService.save(actor);
    }

    @PutMapping("/actors")
    public void saveActor(@RequestBody Actor actor) {
        actorService.save(actor);
    }

    @GetMapping("actors/{actorId}")
    public Actor editActor(@PathVariable("actorId") Integer actorId) {
        return actorService.getActorById(actorId);
    }

}
