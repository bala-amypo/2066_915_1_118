package com.example.demo.dto;

public class SupplierRiskResponse {

    private Long id;
    private String message;
    private boolean resolved;

    public SupplierRiskResponse() {}

    public SupplierRiskResponse(Long id, String message, boolean resolved) {
        this.id = id;
        this.message = message;
        this.resolved = resolved;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
