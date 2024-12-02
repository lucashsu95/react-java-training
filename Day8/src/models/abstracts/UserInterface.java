
package models.abstracts;

public interface UserInterface {
    String getUsername();
    String getPassword();
    String getRole();
    String toPayload();
}