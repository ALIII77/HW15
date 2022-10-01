package Q1.repository;

import Q1.HibernateUtils.HibernateUtils;
import Q1.entity.BankAccount;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BankAccountRepository {


    public void create(BankAccount account) {
        Session session = HibernateUtils.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            session.save(account);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }

    }

    public void delete(BankAccount account) {
        Session session = HibernateUtils.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            session.delete(account);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }

    public BankAccount read(BankAccount account) {
        BankAccount resultAccount = new BankAccount();
        Session session = HibernateUtils.getHibernateSession();
        try (session) {
            resultAccount = session.get(BankAccount.class, account.getAccountNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultAccount;
    }

    public BankAccount read(long id) {
        BankAccount account = new BankAccount();
        Session session = HibernateUtils.getHibernateSession();
        try (session) {
            account = session.get(BankAccount.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    public void update(BankAccount account) {
        Session session = HibernateUtils.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            session.update(account);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
}
