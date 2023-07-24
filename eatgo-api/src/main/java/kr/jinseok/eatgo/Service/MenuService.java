package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.Menu;
import kr.jinseok.eatgo.domain.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    public MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }
    public void update(Long restaurantId, List<Menu> menus){
        for (Menu menu : menus){
            if(menu.isDestroy()) {
                menuRepository.deleteById(menu.getId());
                return;
            }
            menu.setRestaurantId(restaurantId);
            menuRepository.save(menu);
        }

    }
}
