package com.stackoverflow.luiszavaleta.hibernate.dialect;

import org.hibernate.dialect.H2Dialect;

/**
 * Created by Peter Colapietro on 11/17/2014.
 *
 * See: http://stackoverflow.com/a/26371637
 */
public final class ImprovedH2Dialect extends H2Dialect {

    @Override
    public String getDropSequenceString(String sequenceName) {
        // Adding the "if exists" clause to avoid warnings
        return "drop sequence if exists " + sequenceName;
    }

    @Override
    public boolean dropConstraints() {
        // We don't need to drop constraints before dropping tables, that just
        // leads to error messages about missing tables when we don't have a
        // schema in the database
        return false;
    }
}
