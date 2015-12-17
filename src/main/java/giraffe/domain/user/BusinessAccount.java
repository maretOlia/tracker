package giraffe.domain.user;

import giraffe.domain.GiraffeAuthority;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Set;

/**
 * @author Guschcyna Olga
 * @version 1.0.0
 */
@NodeEntity
final public class BusinessAccount extends Account {

    public BusinessAccount(final String login, final String password, final Set<GiraffeAuthority> authorities) {
        super(login, password, authorities);
    }

}
