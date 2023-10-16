package barriga.domain.infra;

import barriga.domain.Usuario;
import barriga.domain.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioMemoryRepository implements UsuarioRepository {

    private List<Usuario> users;
    private Long currentId;

    public UsuarioMemoryRepository() {
        currentId = 0L;
        users = new ArrayList<>();
        salvar(new Usuario(null, "User #1", "user1@gmail.com", "123456" ));
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        Usuario newUser = new Usuario(nextId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        users.add(newUser);
        return newUser;
    }

    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        return users.stream().filter(user->user.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public void printUser(){
        System.out.println(users);
    }
    private Long nextId(){
        return ++currentId;
    }

    public static void main(String[] args){
        UsuarioMemoryRepository repo = new UsuarioMemoryRepository();
        repo.printUser();
        repo.salvar(new Usuario(null, "Usuário qualquer", "userqualeur@gmail.com", "123321"));
        repo.printUser();
    }
}
