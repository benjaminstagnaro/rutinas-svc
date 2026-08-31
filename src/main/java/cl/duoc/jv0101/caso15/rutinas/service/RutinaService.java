package cl.duoc.jv0101.caso15.rutinas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import cl.duoc.jv0101.caso15.rutinas.model.Rutina;
import cl.duoc.jv0101.caso15.rutinas.repository.RutinaRepository;

@Service
public class RutinaService {

    private final RutinaRepository repository;

    public RutinaService(RutinaRepository repository) {
        this.repository = repository;
    }

    public List<Rutina> findAll() {
        return repository.findAll();
    }

    public Optional<Rutina> findById(Long id) {
        return repository.findById(id);
    }

    public Rutina create(Rutina recurso) {
        return repository.save(recurso);
    }

    public Optional<Rutina> update(Long id, Rutina datos) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(datos.getNombre());
            existente.setNivel(datos.getNivel());
            existente.setDuracionMin(datos.getDuracionMin());
            return repository.save(existente);
        });
    }

    public boolean delete(Long id) {
        return repository.findById(id).map(existente -> {
            repository.delete(existente);
            return true;
        }).orElse(false);
    }
}
