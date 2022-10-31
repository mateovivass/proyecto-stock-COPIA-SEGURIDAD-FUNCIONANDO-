
package tup.simple.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tup.simple.models.User;
import tup.simple.repositories.UserRepository;


@RestController

@RequestMapping("")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/add") 
  
  public String addNewUser(@RequestParam String producto, @RequestParam String cantidad, @RequestParam String precio) {

    User user = new User();
    user.setProducto(producto);
    user.setCantidad(cantidad);
    user.setPrecio(precio);
    userRepository.save(user);
    return "Se grabó el nuevo user.";
  }

  @PostMapping("/delete/{id}") // Map ONLY POST Requests
 
  public String deleteUserById(@PathVariable Long id) {
    userRepository.deleteById(id);
    return "Deleted";
  }

  @GetMapping("/{id}")
  public String findUserById(@PathVariable Long id) {
   
    String resp = primeraParte();
    
    if (userRepository.findById(id).isPresent()) {
      
      User user = userRepository.findById(id).get();

      resp += "<tr>"
          + "<td>" + user.getId() + "</td>"
          + "<td>" + user.getProducto() + "</td>"
          + "<td>" + user.getCantidad() + "</td>"
          + "<td>" + user.getPrecio() + "</td>"
          + "</tr>";
    } else {
      resp += "<tr>"
          + "<td>" + "-" + "</td>"
          + "<td>" + "-" + "</td>"
          + "<td>" + "-" + "</td>"
          + "</tr>";

    }
    return resp + "</table>";
  }

  @GetMapping("/all")
  public String getAllUsers() {
    
    Iterable<User> iterable = userRepository.findAll();
    String resp = primeraParte();
    
    for (User user : iterable) {
      resp += "<tr>"
      + "<td>" + user.getId() + "</td>"
      + "<td>" + user.getProducto() + "</td>"
      + "<td>" + user.getCantidad() + "</td>"
      + "<td>" + user.getPrecio() + "</td>"
          + "</tr>";
    }
    return resp + "</table>";
    
    
  }


  @GetMapping("")
  public String hola() {
    return "NO HAY NADA PARA VER ACA";
  }

  private String primeraParte() {
  
     
    return """
          <style>
            #users {
              font-family: Arial, Helvetica, sans-serif;
              border-collapse: collapse;
              width: 55%;
              justify-content: center;
              align-items: center;

            }
            #users td, #users th {
              border: 1px solid #010100;
              padding: 5px;
            }
            #users tr:nth-child(even){background-color: #F0E4C3;}
            
            #users th {
              padding-top: 12px;
              padding-bottom: 12px;
              text-align: left;
              background-color: #C6B986;
              color: #000100;
              d
            }

            
            
          </style>
          <table id='users'>
            <tr>
              <th>Id</th>
              <th>Producto</th>
              <th>Cantidad</th>
              <th>Precio</th>
            </tr>

        """;
  }
}
