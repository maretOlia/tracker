package giraffe.domain.user;

import giraffe.domain.GiraffeEntity;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Guschcyna Olga
 * @version 1.0.0
 */
//TODO handle 'single sign on'
@NodeEntity
final public class User extends GiraffeEntity {

    private String login;

    private String password;

    private String salt;

    @Relationship(type="HAS_ACCOUNT", direction = Relationship.OUTGOING)
    private Set<Account> accounts = new HashSet<>();


    private User(){ }

    public User(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public void hasAccount(final Account account) {
        accounts.add(account);
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(final String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, salt);
    }
}