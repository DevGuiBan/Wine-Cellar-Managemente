package controller;

import dto.ClientDTO;
import entity.Client;
import service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> cadastrar(@RequestBody @Valid ClientDTO clientDTO) {
        Client client = clientService.save(clientDTO);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> listarTodos() {
        List<ClientDTO> clients = clientService.listAll();
        return ResponseEntity.ok(clients);
    }
}
