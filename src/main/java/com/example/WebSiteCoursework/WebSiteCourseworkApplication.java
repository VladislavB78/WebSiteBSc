package com.example.WebSiteCoursework;

import com.example.WebSiteCoursework.entities.MainProduct;
import com.example.WebSiteCoursework.entities.ProductType;
import com.example.WebSiteCoursework.repositories.MainProductRepository;
import com.example.WebSiteCoursework.repositories.ProductTypesRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebSiteCourseworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSiteCourseworkApplication.class, args);
	}

	@Autowired
	private ProductTypesRepository productTypesRepository;
	@Autowired
	private MainProductRepository mainProductRepository;

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
//			productTypesRepository.save(new ProductType("кухонный"));
//			productTypesRepository.save(new ProductType("письменный"));

//			ProductType productType = new ProductType("кухонный");
//
//			productType.addMainProduct(new MainProduct("Хьюстон", 7599, "Производитель: ТриЯ\nМатериал: ЛДСП\nРазмер: 800x750x800", "../images/houston_1.jpeg"));
//			productTypesRepository.save(productType);
//			productType.addMainProduct(new MainProduct("AVATAR", 92000, "Производитель: TetChair (Тэтчер)\nМатериал: Дерево гевея\nРазмер: 1100x750x2200", "../images/avatar_1.jpg"));
//			productTypesRepository.save(productType);
//
//			productType = new ProductType("письменный");
//
//			productType.addMainProduct(new MainProduct("Миллениум 2", 22413, "Производитель: Мебельсон\nМатериал: ЛДСП\nРазмер: 1860x578x2110", "../images/millennium_2.jpeg"));
//			productTypesRepository.save(productType);
//			productType.addMainProduct(new MainProduct("Модуль № 129", 8540, "Производитель: М Сервис\nМатериал: ДСП, МДФ\nРазмер: 1200x760x600", "../images/modul129_2.png"));
//			productTypesRepository.save(productType);

//			mainProductRepository.save(new MainProduct("Хьюстон", 7599, ,"Производитель: ТриЯ\nМатериал: ЛДСП\nРазмер:800x750x800", "../images/houston_1.jpeg"));

			// https://mebeldol.ru/
//			mainProductRepository.save(new MainProduct("Хьюстон", 7599, 1, "Производитель: ТриЯ\nМатериал: ЛДСП\nРазмер:800x750x800", "../images/houston_1.jpeg"));
//			mainProductRepository.save(new MainProduct("AVATAR", 92000, 1, "Производитель: TetChair (Тэтчер)\nМатериал: Дерево гевея\nРазмер:1100x750x2200", "../images/avatar_1.jpg"));
//			mainProductRepository.save(new MainProduct("Миллениум 2", 22413, 2, "Производитель: Мебельсон\nМатериал: ЛДСП\nРазмер:1860x578x2110", "../images/millennium_2.jpeg"));
//			mainProductRepository.save(new MainProduct("Модуль № 129", 8540, 2, "Производитель: М Сервис\nМатериал: ДСП, МДФ\nРазмер:1200x760x600", "../images/modul129_2.png"));
//
//			mainProductRepository.save(new MainProduct("ЕВРО", 6000, 1, "Производитель: Ульяновск\nМатериал: ЛДСП / Пластик\nРазмер:1000х680х750", "../images/euro_1.jpg"));
//			mainProductRepository.save(new MainProduct("BORNEO", 18600, 1, "Производитель: Радуга\nМатериал: Массив дерева, МДФ\nРазмер:1100x750x1100", "../images/borneo_1.jpg"));
//			mainProductRepository.save(new MainProduct("Виктория", 6780, 2, "Производитель: Ижмебель\nМатериал: ЛДСП, МДФ\nРазмер:1200x736x590", "../images/viktoria_2.jpg"));
//			mainProductRepository.save(new MainProduct("Бомбей", 35890, 2, "Производитель: TetChair (Тэтчер)\nМатериал: Дерево\nРазмер:900х600х760", "../images/bombei_2.jpg"));
//
//			mainProductRepository.save(new MainProduct("Bosco", 17590, 1, "Производитель: TetChair (Тэтчер)\nМатериал: МДФ, бук\nРазмер:900x750x900", "../images/bosco_1.jpg"));
//			mainProductRepository.save(new MainProduct("Navarrese", 30690, 1, "Производитель: TetChair (Тэтчер)\nМатериал: Массив\nРазмер:900x760x900", "../images/navarrese_1.jpg"));
//			mainProductRepository.save(new MainProduct("Калгари", 9300, 2, "Производитель: МебельГрад\nМатериал: ЛДСП, МДФ, массив\nРазмер:1200х540х770", "../images/kalgari_2.png"));
//			mainProductRepository.save(new MainProduct("Базис 3", 7360, 2, "Производитель: Моби\nМатериал: ЛДСП\nРазмер:1100х600х840", "../images/bazis3_2.jpg"));
		};
	}

}
