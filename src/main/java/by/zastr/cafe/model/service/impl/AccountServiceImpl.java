package by.zastr.cafe.model.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.zastr.cafe.exception.DaoException;
import by.zastr.cafe.exception.ServiceException;
import by.zastr.cafe.model.dao.EntityTransaction;
import by.zastr.cafe.model.dao.impl.AccountDaoImpl;
import by.zastr.cafe.model.entity.Account;
import by.zastr.cafe.model.service.AccountService;
import by.zastr.cafe.model.service.CafeService;

/**
 * class AccountServiceImpl.
 *
 * @author A.Zastrozhyn
 */
public class AccountServiceImpl implements CafeService<Account>, AccountService{
	private static AccountServiceImpl instance = new AccountServiceImpl();;
	private AccountDaoImpl accountDao;
	private EntityTransaction entityTransaction;	
	private AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
		entityTransaction = new EntityTransaction();
	}

	/**
	 * Gets the single instance of AccountServiceImpl.
	 *
	 * @return single instance of AccountServiceImpl
	 */
	public static AccountServiceImpl getInstance() {
        return instance;
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 * @throws ServiceException the service exception
	 */
	@Override
	public Optional<Account> findById(int id) throws ServiceException{
		Optional<Account> account = Optional.empty();
		try {
			entityTransaction.begin(accountDao);
			account = accountDao.findById(id);
		} catch (DaoException e) {
			throw new ServiceException("Service exception in method finding account by id", e);
		}
		finally {
			entityTransaction.end();
		}
		return account;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws ServiceException the service exception
	 */
	@Override
	public List<Account> findAll() throws ServiceException {
		List<Account> accountList = new ArrayList<Account>();
		entityTransaction.begin(accountDao);
		try {
			accountList = accountDao.findAll();
		} catch (DaoException e) {
			throw new ServiceException("Service exception in method find all account", e);
		}
		finally {
			entityTransaction.end();
		}
		return accountList;
	}

	/**
	 * Delete account.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws ServiceException the service exception
	 */
	@Override
	public boolean delete(int id) throws ServiceException {
		try {
			entityTransaction.begin(accountDao);
			return accountDao.delete(id);
		} catch (DaoException e) {
			throw new ServiceException("Service exception in method delete order", e);
		}
		finally {
			entityTransaction.end();
		}

	}
		
	/**
	 * Creates the new default account.
	 *
	 * @return default Account
	 * @throws ServiceException the service exception
	 */
	@Override
	public Account CreateNewDefaultAccount() throws ServiceException {
		Account account = new Account();
		try {
			entityTransaction.begin(accountDao);
			account = accountDao.createNewDefaultAccount();
		} catch (DaoException e) {
			throw new ServiceException("Service exception in method get id of new default account", e);
		}
		finally {
			entityTransaction.end();
		} 
		return account;
	}
	
	/**
	 * Update account.
	 *
	 * @param account the account
	 * @return true, if successful
	 * @throws ServiceException the service exception
	 */
	@Override
	public boolean update(Account account) throws ServiceException {
		try {
			entityTransaction.begin(accountDao);
			return accountDao.update(account);
		} catch (DaoException e) {
			throw new ServiceException("Service exception in method update account", e);
		}
		finally {
			entityTransaction.end();
		}
	}

}
