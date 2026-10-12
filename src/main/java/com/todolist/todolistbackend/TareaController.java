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

    @GetMapping
    public List<Tarea> obtenerTodas() {
        return repositorio.findAll();
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        tarea.setId(null);
        return repositorio.save(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        tarea.setId(id);
        return repositorio.save(tarea);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}