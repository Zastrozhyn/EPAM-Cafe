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
import jakarta.servlet.http.HttpServletRequest;

public class EditDishCommand implements Command{

	@Override
	public Router execute(HttpServletRequest request) throws CommandException {
		Router router = new Router();
		router.setPagePath(PagePath.MAIN_PAGE);
		router.setRedirect();
		int id = Integer.parseInt(request.getParameter(DISH_ID));
		String name = request.getParameter(NAME);
		String type = request.getParameter(DISH_TYPE);
		String description = request.getParameter(DESCRIPTION);
		String price = request.getParameter(DISH_PRICE);
		String weight = request.getParameter(DISH_WEIGHT);
		DishServiceImpl dishService = DishServiceImpl.getInstance();
		try {
			String result = dishService.update(id, name, weight, price, description, type);
			request.setAttribute(AttributeName.MESSAGE, result);
			if (!result.equals(UserMessage.ADD_DISH_SUCCESSFUL)) {
				router.setPagePath(PagePath.EDIT_DISH);
				router.setForward();
			}
			
		} catch (ServiceException e) {
			logger.log(Level.ERROR, "Dish cannot be add:", e);
            throw new CommandException("User cannot be add:", e);
		}
		return router;
	}
	

}
