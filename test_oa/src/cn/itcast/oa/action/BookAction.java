package cn.itcast.oa.action;

import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Book;
@SuppressWarnings("serial")
@Controller
public class BookAction  extends BaseAction<Book>{
      @Override
    public String execute() throws Exception {
    	  System.out.println(model);
    	  bookService.save(model);
    	return NONE;
    }
	
}
