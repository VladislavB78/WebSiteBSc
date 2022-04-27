package com.example.WebSiteCoursework;

import com.example.WebSiteCoursework.entities.*;
import com.example.WebSiteCoursework.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class WebSiteCourseworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSiteCourseworkApplication.class, args);
	}

	@Bean
	public CommandLineRunner sendDatabase(ProductTypesRepository ptr, ProductRepository pr, CustomerRepository cr,
										  OrderStatusRepository ost, MyOrderRepository mor) {
		return args -> {
			ProductType pt1 = new ProductType("кухонный");
			ProductType pt2 = new ProductType("письменный");
			ptr.save(pt1);
			ptr.save(pt2);
//			 https://mebeldol.ru/
			pr.save(new Product("Хьюстон", 7599, pt1, "Производитель: ТриЯ\nМатериал: ЛДСП\nРазмер:800x750x800", "../images/houston_1.jpeg"));
			pr.save(new Product("AVATAR", 92000, pt1, "Производитель: TetChair (Тэтчер)\nМатериал: Дерево гевея\nРазмер:1100x750x2200", "../images/avatar_1.jpg"));
			pr.save(new Product("Миллениум 2", 22413, pt2, "Производитель: Мебельсон\nМатериал: ЛДСП\nРазмер:1860x578x2110", "../images/millennium_2.jpeg"));
			pr.save(new Product("Модуль № 129", 8540, pt2, "Производитель: М Сервис\nМатериал: ДСП, МДФ\nРазмер:1200x760x600", "../images/modul129_2.png"));

			pr.save(new Product("ЕВРО", 6000, pt1, "Производитель: Ульяновск\nМатериал: ЛДСП / Пластик\nРазмер:1000х680х750", "../images/euro_1.jpg"));
			pr.save(new Product("BORNEO", 18600, pt1, "Производитель: Радуга\nМатериал: Массив дерева, МДФ\nРазмер:1100x750x1100", "../images/borneo_1.jpg"));
			pr.save(new Product("Виктория", 6780, pt2, "Производитель: Ижмебель\nМатериал: ЛДСП, МДФ\nРазмер:1200x736x590", "../images/viktoria_2.jpg"));
			pr.save(new Product("Бомбей", 35890, pt2, "Производитель: TetChair (Тэтчер)\nМатериал: Дерево\nРазмер:900х600х760", "../images/bombei_2.jpg"));

			pr.save(new Product("Bosco", 17590, pt1, "Производитель: TetChair (Тэтчер)\nМатериал: МДФ, бук\nРазмер:900x750x900", "../images/bosco_1.jpg"));
			pr.save(new Product("Navarrese", 30690, pt1, "Производитель: TetChair (Тэтчер)\nМатериал: Массив\nРазмер:900x760x900", "../images/navarrese_1.jpg"));
			pr.save(new Product("Калгари", 9300, pt2, "Производитель: МебельГрад\nМатериал: ЛДСП, МДФ, массив\nРазмер:1200х540х770", "../images/kalgari_2.png"));
			pr.save(new Product("Базис 3", 7360, pt2, "Производитель: Моби\nМатериал: ЛДСП\nРазмер:1100х600х840", "../images/bazis3_2.jpg"));

			OrderStatus os = new OrderStatus("Ожидает отправки");
			ost.save(os);

//			Customer c = new Customer("Иван", "Иванов", "test@test.com", "123445 Город Улица", "1", "1");
//			cr.save(c);

//			Product mp = new Product("Navarrese", 30690, pt1, "Производитель: TetChair (Тэтчер)\nМатериал: Массив\nРазмер:900x760x900", "../images/navarrese_1.jpg");
//			pr.save(mp);
//			mor.save(new MyOrder(c, mp, os));

			cr.save(new Customer("a", "1", true, Collections.singleton(Role.ADMIN)));
			cr.save(new Customer("", "", true, Collections.singleton(Role.CUSTOMER)));
		};
	}

}
