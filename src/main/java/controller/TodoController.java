package controller;


import model.Todo;
import org.springframework.web.bind.annotation.*;
import service.TodoService;

import java.util.List;


//Controlador na parte WEB
@RestController
//Ele irá ser chamado para executar certo comando por esse 'diretório'
@RequestMapping("/todos")

public class TodoController {

    TodoService todoService;

    //Injeção de Dependência
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //Anotação de Solicitação HTTP
    @PostMapping
    //ResquestBody é um Requição de Corpo, esta 'chamado' um objeto especifico por essa anotação
    public List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }

    @PutMapping
    public List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    //No caso da Requesição HTTP do Delete é preciso passar um parâmetro na Rota.
    @DeleteMapping("{id}")
    public List<Todo> delete(@PathVariable Long id){
        return  todoService.delete(id);
    }

    @GetMapping
    public List<Todo> list(){
        return todoService.list();
    }

}
