
import java.io.Serializable;
import java.sql.*;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class DepartmentIdGenerator extends SequenceStyleGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session,
                                 Object object) throws HibernateException {

        Connection connection = session.connection();
        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select count(accountnumber) from bankaccount");

            rs.next();
            return rs.getInt(1) + 1_000_000L;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
}