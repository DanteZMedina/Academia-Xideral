package com.example.copilot.pojo;

/**
 * Data Transfer Object (DTO) para la entidad User.
 *
 * <p>Esta clase fue generada con asistencia de GitHub Copilot.
 * Encapsula los datos de usuario que se exponen a través de la API REST,
 * omitiendo campos sensibles como la contraseña.</p>
 *
 * <p><b>Caso de uso Copilot:</b> Copilot generó esta clase completa al escribir
 * únicamente el comentario de clase, infiriendo los campos típicos de un
 * usuario en una aplicación web.</p>
 */
public class UserDTO {

    /** Identificador único del usuario. */
    private Long id;

    /** Nombre de usuario (único en el sistema). */
    private String username;

    /** Correo electrónico del usuario. */
    private String email;

    /** Nombre completo del usuario. */
    private String fullName;

    /** Rol del usuario en el sistema (ej: ADMIN, USER). */
    private String role;

    /** Indica si la cuenta del usuario está activa. */
    private boolean active;

    // -----------------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------------

    /** Constructor vacío requerido por frameworks de serialización. */
    public UserDTO() {}

    /**
     * Constructor con todos los campos.
     *
     * @param id       identificador del usuario
     * @param username nombre de usuario
     * @param email    correo electrónico
     * @param fullName nombre completo
     * @param role     rol del usuario
     * @param active   estado de la cuenta
     */
    public UserDTO(Long id, String username, String email,
                   String fullName, String role, boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.active = active;
    }

    // -----------------------------------------------------------------------
    // Getters y Setters
    // -----------------------------------------------------------------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    // -----------------------------------------------------------------------
    // toString
    // -----------------------------------------------------------------------

    /**
     * Representación en cadena del DTO (sin datos sensibles).
     *
     * @return cadena con los campos públicos del usuario
     */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                '}';
    }
}
