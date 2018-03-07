package com.hhu.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
@Controller
public class JDBCController {
    @Autowired
    private DataSource dataSource;

    public void execute() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
