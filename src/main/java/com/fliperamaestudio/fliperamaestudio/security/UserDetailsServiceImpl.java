package com.fliperamaestudio.fliperamaestudio.security;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.repository.UserRepository;
import com.fliperamaestudio.fliperamaestudio.service.SessionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@SessionAttributes("usuario")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;



    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;


    }


    public void salvaSession(Usuario usr, Usuario usuario){
        usr.setNome(usuario.getNome());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        var usuario = this.userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Email não encontrado"));


        


        return new UserPrincipal(usuario);
    }
}
