@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    // Note: If request has username, use getUsername(). 
    // If your code used getEmail(), make sure LoginRequest has an email field.
    String identifier = request.getUsername(); 
    // ...
}