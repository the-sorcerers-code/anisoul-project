package com.sorcererscode.anisoul.auth;

public interface AuthService {
    public AuthenticationResponse register(RegistrationRequest request);

    public AuthenticationResponse authenticate(AuthRequest request);
}
