package uz.bakhodirov.springtemplate.repository.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.bakhodirov.springtemplate.entity.todo.Todo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    boolean existsByNameAndDeletedFalse(String name);

     @Query(value = "select * from todo t where t.user_id=?1 and not t.deleted",nativeQuery = true)
    List<Todo> findAllTodo(Long id);

    @Query(value = "select * from todo t where t.user_id=?2 and t.id=?1 and not t.deleted",nativeQuery = true)
    Optional<Todo> findByIdUserTodo(Long id, Long sessionId);

    @Transactional
    @Modifying
    @Query(value = "update todo t set deleted=true where  t.id=?1 and not t.deleted",nativeQuery = true)
    void deletedTodo(Long id);


     List<Todo> findAllByDeletedFalse();

    Optional<Todo> findByIdAndDeletedFalse(Long id);
}
