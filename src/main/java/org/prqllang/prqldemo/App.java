package org.prqllang.prqldemo;

import org.prql.prql4j.PrqlCompiler;

public class App {
    public static void main(String[] args) {
        var sql = PrqlCompiler.toSql("" +
                "from orders\n" +
                "derive total = items_sum - promo_sum\n" +
                "derive day_of_the_week = s'EXTRACT(dow FROM created_at)'\n" +
                "group day_of_the_week (\n" +
                "  aggregate [total = sum total]\n" +
                ")\n" +
                "sort day_of_the_week");

        System.out.println(sql);
    }
}
