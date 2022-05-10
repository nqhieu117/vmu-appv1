package hieu.vimaru.vmuapp.Models;

public class res {
    private String _id;
    private String username;
    private String role;
    private String jwt;

    public res(String _id, String username, String role, String jwt) {
        this._id = _id;
        this.username = username;
        this.role = role;
        this.jwt = jwt;
    }

    public res() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}

