package ru.shaitanshamma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.Category;
import ru.shaitanshamma.entities.dot.CategoryRepr;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select new ru.shaitanshamma.entities.dot.CategoryRepr(c.id, c.title, count(p.id)) " +
            "from Category c " +
            "left join c.products p " +
            "group by c.id, c.title")
    List<CategoryRepr> getAllCategoryRepr();
}
