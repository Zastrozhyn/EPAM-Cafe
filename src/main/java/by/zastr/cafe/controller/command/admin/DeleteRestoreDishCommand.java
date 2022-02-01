package by.zastr.cafe.controller.command.admin;

import static by.zastr.cafe.controller.command.RequestParameter.*;

import org.apache.logging.log4j.Level;

import by.zastr.cafe.controller.command.AttributeName;
import by.zastr.cafe.controller.command.Command;
import by.zastr.cafe.controller.command.PagePath;
import by.zastr.cafe.controller.command.Router;
import by.zastr.cafe.controller.command.UserMessage;
import by.zastr.cafe.exception.CommandException;
import by.zastr.cafe.exception.ServiceException;
import by.zastr.cafe.model.service.impl.DishServiceImpl;
import by.zastr.cafe.util.MessageManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class DeleteRestoreDishCommand implements Command{

	@Override
	public Router execute(HttpServletRequest request) throws CommandException {
		HttpSession session = request.getSession();
		Router router = new Router();
		router.setPagePath(PagePath.EDIT_DISH);
		String locale = (String) session.getAttribute(AttributeName.SESSION_LOCALE);
		MessageManager messageManager = MessageManager.defineLocale(locale);
		int dishId = Integer.parseInt(request.getParameter(DISH_ID));
		boolean archive = Boolean.parseBoolean(request.getParameter(ARCHIVE));
		DishServiceImpl dishService = DishServiceImpl.getInstance();
		try {
			if(!archive) {
				dishService.delete(dishId);
			}
			else {
				dishService.restore(dishId);
			}
			request.setAttribute(AttributeName.MESSAGE, messageManager.getMessage(UserMessage.SUCCESSFUL));
		} catch (ServiceException e) {
			logger.log(Level.ERROR, "Cannot delete dish", e);
            throw new CommandException("Cannot delete dish", e);
		}
		return router;		
	}
}