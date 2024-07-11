package org.example.SqlBuilder;

import org.example.entity.User;

public class StudentSqlBuilder {

        public String buildUpdateUserByUserId(User user) {
            StringBuilder sql = new StringBuilder("UPDATE \"dm8\".\"users\" SET ");

            if (user.getEmail() != null) {
                sql.append("\"email\" = #{email}, ");
            }
            if (user.getPhone() != null) {
                sql.append("\"phone\" = #{phone}, ");
            }
            if (user.getSex() != null) {
                sql.append("\"sex\" = #{sex}, ");
            }
            if (user.getIdCard() != null) {
                sql.append("\"id_card\" = #{idCard}, ");
            }

            // Remove the trailing comma and space
            if (sql.toString().endsWith(", ")) {
                sql.setLength(sql.length() - 2);
            }

            sql.append(" WHERE \"id\" = #{id}");

            return sql.toString();
        }


}
