package service;

import model.Todo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    //Injeção de Dependência
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> list(){
        //Consuta por Ordenação de prioridade e depois pelo Nome
        Sort sort = Sort.by("prioridade").descending().and(Sort.by(
                "descricao").ascending()).ascending();

        return todoRepository.findAll(sort);

    }


    public List<Todo> create(Todo todo){

        //Criando um tarefa e retornando sempre a Listagem desta tarefa
        todoRepository.save(todo);

        return list();
    }

    public List<Todo> update(Todo todo){

        //Atualizando o objeto que quer ser modficado e salvo
        todoRepository.save(todo);

        return list();

    }

    public List<Todo> delete(Long id){

        //Seleciona o ID do Classe de Entidade para o deletar
        todoRepository.deleteById(id);

        return list();
    }


}
