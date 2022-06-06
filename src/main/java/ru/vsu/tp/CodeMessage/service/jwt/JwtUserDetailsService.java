package ru.vsu.tp.CodeMessage.service.jwt;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vsu.tp.CodeMessage.entity.Account;
import ru.vsu.tp.CodeMessage.repository.AccountsRepository;

import java.util.Collections;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private AccountsRepository accountsRepository;

    public JwtUserDetailsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<Account> account
                = accountsRepository.findByUsername(username);
        if (account.isPresent()) {
            final String dbUsername = account.get().getUsername();
            final String dbPassword = account.get().getPassword();
            return new User(dbUsername, dbPassword, Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("Account with that username not found");
        }
    }

}

