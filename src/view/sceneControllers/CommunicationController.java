package view.sceneControllers;

/**
 *
 * @author milar
 */
public final class CommunicationController {
    
    private static final CommunicationController commController = new CommunicationController();
    
    private ProductsPaneController productsPaneController = null;
    private CategoryPaneController categoryPaneController = null;
    private MenuPaneController menuPaneController = null;
    private EmployeesListController employeesListController = null;
    private UtilitiesPaneController utilitiesPaneController = null;
    
    private CommunicationController() {
    }

    public static CommunicationController getInstance(){
        return commController;
    }

    public void setCategoryPaneController(CategoryPaneController catController){
        if(this.categoryPaneController == null){
            this.categoryPaneController = catController;
        }
    }
    
    public CategoryPaneController getCategoryPaneController(){
        return this.categoryPaneController;
    }
    
    public void setProductPaneController(ProductsPaneController productsPaneController){
        if(this.productsPaneController == null){
            this.productsPaneController = productsPaneController;
        }
    }
    
    public ProductsPaneController getProductsPaneController(){
        return this.productsPaneController;
    }
    
    public void setUtilitiesPaneController(UtilitiesPaneController utilitiesPaneController){
        if(this.utilitiesPaneController == null){
            this.utilitiesPaneController = utilitiesPaneController;
        }
    }
    
    public UtilitiesPaneController getUtilitiesPaneController(){
        return this.utilitiesPaneController;
    }
    
    
    public void setMenuPaneController(MenuPaneController menuPaneController){
        if(this.menuPaneController == null){
            this.menuPaneController = menuPaneController;
        }
    }
    
    public MenuPaneController getMenuPaneController(){
        return this.menuPaneController;
    }
    
    public void setEmployeePaneController(EmployeesListController employeesListController){
        if(this.employeesListController == null){
            this.employeesListController = employeesListController;
        }
    }
    
    public EmployeesListController getEmployeePaneController(){
        return this.employeesListController;
    }
}
