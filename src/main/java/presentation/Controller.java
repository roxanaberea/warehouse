package presentation;

import businessLogicLayer.ClientBLL;
import businessLogicLayer.OrderBLL;
import businessLogicLayer.ProductBLL;
import model.Client;
import model.Order;
import model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    ClientGUI clientGUI;
    OrderGUI orderGUI;
    ProductGUI productGUI;
    MainGUI mainGUI = new MainGUI();
    ClientBLL clientBLL = new ClientBLL();
    ProductBLL productBLL = new ProductBLL();
    OrderBLL orderBLL = new OrderBLL();
    public Controller(){
        mainGUI.setVisible(true);
        mainGUI.getClientB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientGUI = new ClientGUI();
                clientGUI.setVisible(true);
                mainGUI.setVisible(false);
                clientGUI.getAddB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clientBLL.insC(new Client(clientGUI.getAddIDText(), clientGUI.getAddFirstNameText(), clientGUI.getAddLastNameText(),
                                clientGUI.getAddAgeText()));
                    }
                });
                clientGUI.getEditB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!clientGUI.getEditFirstNameText().equals("")){
                            clientBLL.upC("firstName", clientGUI.getEditFirstNameText(), Integer.parseInt(clientGUI.getEditIDText()));
                        }
                        if(!clientGUI.getEditLastNameText().equals("")){
                            clientBLL.upC("lastName", clientGUI.getEditLastNameText(), Integer.parseInt(clientGUI.getEditIDText()));
                        }
                        if(!clientGUI.getEditAgeText().equals("")){
                            clientBLL.upC("age", clientGUI.getEditAgeText(), Integer.parseInt(clientGUI.getEditIDText()));
                        }
                    }
                });
                clientGUI.getDeleteB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clientBLL.delC(clientGUI.getDeleteIDText());
                    }
                });
                clientGUI.getBackB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clientGUI.dispose();
                        mainGUI.setVisible(true);
                    }
                });
                clientGUI.getClientsB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ShowCGUI showCGUI = new ShowCGUI(clientBLL.see());
                        showCGUI.setVisible(true);
                        clientGUI.setVisible(false);
                        showCGUI.getBack().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                showCGUI.dispose();
                                clientGUI.setVisible(true);
                            }
                        });
                    }
                });
            }
        });
        mainGUI.getOrderB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderGUI = new OrderGUI();
                orderGUI.setVisible(true);
                mainGUI.setVisible(false);
                orderGUI.getAddB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        orderBLL.insO(new Order(orderGUI.getAddIDText(), orderGUI.getAddClientIDText(),
                                orderGUI.getAddProductIDText(), orderGUI.getAddQuantityText()));
                    }
                });
                orderGUI.getEditB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!((orderGUI.getEditClientIDText())).equals("")){
                            orderBLL.upO("clientID", String.valueOf(orderGUI.getEditClientIDText()), Integer.parseInt(orderGUI.getEditIDText()));
                        }
                        if(!((orderGUI.getEditProductIDText())).equals("")){
                            orderBLL.upO("productID", String.valueOf(orderGUI.getEditProductIDText()), Integer.parseInt(orderGUI.getEditIDText()));
                        }
                        if(!((orderGUI.getEditAgeText()).equals(""))){
                            orderBLL.upO("quantity", String.valueOf(orderGUI.getEditAgeText()), Integer.parseInt(orderGUI.getEditIDText()));
                        }
                    }
                });
                orderGUI.getDeleteB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        orderBLL.delO(orderGUI.getDeleteIDText());
                    }
                });
                orderGUI.getBackB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        orderGUI.dispose();
                        mainGUI.setVisible(true);
                    }
                });
                orderGUI.getOrdersB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ShowCGUI showCGUI = new ShowCGUI(orderBLL.see());
                        showCGUI.setVisible(true);
                        orderGUI.setVisible(false);

                        showCGUI.getBack().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                showCGUI.dispose();
                                orderGUI.setVisible(true);
                            }
                        });
                    }
                });
            }
        });
        mainGUI.getProductB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productGUI = new ProductGUI();
                productGUI.setVisible(true);
                mainGUI.setVisible(false);
                productGUI.getAddB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        productBLL.insP(new Product(productGUI.getAddIDText(), productGUI.getAddNameText(),
                                productGUI.getAddPriceText(), productGUI.getAddQuantityText()));
                    }
                });
                productGUI.getEditB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!productGUI.getEditNameText().equals("")){
                            productBLL.updP("name", productGUI.getEditNameText(), productGUI.getEditIDText());
                        }
                        if(!productGUI.getEditPriceText().equals("")){
                            productBLL.updP("price", productGUI.getEditPriceText(), productGUI.getEditIDText());
                        }
                        if(!productGUI.getEditQuantityText().equals("")){
                            productBLL.updP("quantity", productGUI.getEditQuantityText(), productGUI.getEditIDText());
                        }
                    }
                });
                productGUI.getDeleteB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        productBLL.delP(productGUI.getDeleteIDText());
                    }
                });
                productGUI.getBackB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        productGUI.dispose();
                        mainGUI.setVisible(true);
                    }
                });
                productGUI.getProductsB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ShowCGUI showCGUI = new ShowCGUI(productBLL.see());
                        showCGUI.setVisible(true);
                        productGUI.setVisible(false);

                        showCGUI.getBack().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                showCGUI.dispose();
                                productGUI.setVisible(true);
                            }
                        });
                    }
                });
            }
        });
    }
}

