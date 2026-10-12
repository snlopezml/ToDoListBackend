package com.todolist.todolistbackend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
public class TareaController {

    private final TareaRepository repositorio;

    public TareaController(TareaRepository repositorio) {
        this.repositorio = repositorio;
    }

    // Dame todas las tareas
    @GetMapping
    public List<Tarea> obtenerTodas() {
        return repositorio.findAll();
    }

    // Guarda una tarea nueva
    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return repositorio.save(tarea);
    }

    // Actualiza una tarea existente
    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        tarea.setId(id);
        return repositorio.save(tarea);
    }

    // Borra una tarea por su id
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}