@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
    if (userRepository.existsByUsername(request.getUsername())) {
        return ResponseEntity.badRequest().body("Username exists");
    }
    AppUser user = new AppUser();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole(request.getRole());
    return ResponseEntity.ok(userRepository.save(user));
}