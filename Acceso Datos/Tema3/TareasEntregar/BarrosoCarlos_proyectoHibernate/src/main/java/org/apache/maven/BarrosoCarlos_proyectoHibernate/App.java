package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        ClientesDAO clienteDao = new ClientesDAO();
        ProductosDAO productosDao = new ProductosDAO();
        ProveedoresDAO proveedoresDao = new ProveedoresDAO();
        PedidoDAO pedidoDao = new PedidoDAO();

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                "SELECCIONE UNA OPCIÓN:\n" +
                "1. BUSCAR CLIENTE\n" + "\n" +
                "2. AÑADIR CLIENTE\n" + "\n" +
                "3. ACTUALIZAR CLIENTE\n" + "\n" +
                "4. BUSCAR PRODUCTO\n" + "\n" +
                "5. AÑADIR PRODUCTO\n" + "\n" +
                "6. ACTUALIZAR PRODUCTO\n" + "\n" +
                "7. BUSCAR PROVEEDOR\n" + "\n" +
                "8. AÑADIR PROVEEDOR\n" + "\n" +
                "9. ACTUALIZAR PROVEEDOR\n" + "\n" +
                "10. BUSCAR PEDIDO\n" + "\n" +
                "11. AÑADIR PEDIDO\n" + "\n" +
                "12. SALIR");

            if (opcion == null || opcion.equals("12")) {
                JOptionPane.showMessageDialog(null, "SALIENDO...");
                break;
            }

            if (opcion.equals("1")) {
                int idCliente = Integer.parseInt(JOptionPane.showInputDialog("INGRESE ID  DEL CLIENTE:"));
                Clientes cliente = clienteDao.buscarCliente(idCliente);
                if (cliente != null) {
                    JOptionPane.showMessageDialog(null, cliente.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO");
                }
            } 
            
            else if (opcion.equals("2")) {
                int newId = Integer.parseInt(JOptionPane.showInputDialog("INGRESE ID  DEL NUEVO CLIENTE:"));
                String nombre = JOptionPane.showInputDialog("INGRESE NOMBRE:");
                String direccion = JOptionPane.showInputDialog("INGRESE DIRECCIÓN:");
                String telefono = JOptionPane.showInputDialog("INGRESE TELÉFONO:");
                String email = JOptionPane.showInputDialog("INGRESE EMAIL:");
                clienteDao.aniadirCliente(new Clientes(newId, nombre, direccion, telefono, email));
                JOptionPane.showMessageDialog(null, "CLIENTE AÑADIDO EXITOSAMENTE");
            } 
            else if (opcion.equals("3")) {
                int idCliente = Integer.parseInt(JOptionPane.showInputDialog("INGRESE ID DEL CLIENTE A ACTUALIZAR:"));
                Clientes cliente = clienteDao.buscarCliente(idCliente);

                if (cliente != null) {
                    String nuevoNombre = JOptionPane.showInputDialog("INGRESE NUEVO NOMBRE:", cliente.getNombre());
                    String nuevaDireccion = JOptionPane.showInputDialog("INGRESE NUEVA DIRECCIÓN:", cliente.getDireccion());
                    String nuevoTelefono = JOptionPane.showInputDialog("INGRESE NUEVO TELÉFONO:", cliente.getTelefono());
                    String nuevoEmail = JOptionPane.showInputDialog("INGRESE NUEVO EMAIL:", cliente.getEmail());

                    cliente.setNombre(nuevoNombre);
                    cliente.setDireccion(nuevaDireccion);
                    cliente.setTelefono(nuevoTelefono);
                    cliente.setEmail(nuevoEmail);

                    clienteDao.actualizarCliente(cliente);
                    JOptionPane.showMessageDialog(null, "CLIENTE ACTUALIZADO EXITOSAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO");
                }
            }
            
            else if (opcion.equals("4")) {
                String nombreProducto = JOptionPane.showInputDialog("INGRESE NOMBRE DEL PRODUCTO:");
                Productos producto = productosDao.buscarProducto(nombreProducto);
                if (producto != null) {
                    JOptionPane.showMessageDialog(null, producto.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO");
                }
            } 
            
            else if (opcion.equals("5")) {
                int newId = Integer.parseInt(JOptionPane.showInputDialog("INGRESE ID  DEL NUEVO PRODUCTO:"));
                String nombre = JOptionPane.showInputDialog("INGRESE NOMBRE:");
                String categoria = JOptionPane.showInputDialog("INGRESE CATEGORÍA:");
                float precio = Float.parseFloat(JOptionPane.showInputDialog("INGRESE PRECIO:"));
                int stock = Integer.parseInt(JOptionPane.showInputDialog("INGRESE STOCK:"));

                productosDao.anadirProducto(new Productos(newId, nombre, categoria, precio, stock));
                JOptionPane.showMessageDialog(null, "PRODUCTO AÑADIDO EXITOSAMENTE");
            } 
            
            else if (opcion.equals("6")) {
                String nombreProducto = JOptionPane.showInputDialog("INGRESE EL NOMBRE DEL PRODUCTO A ACTUALIZAR:");
                Productos producto = productosDao.buscarProducto(nombreProducto);

                if (producto != null) {
                    String nuevoNombre = JOptionPane.showInputDialog("INGRESE NUEVO NOMBRE:", producto.getNombre());
                    String nuevaCategoria = JOptionPane.showInputDialog("INGRESE NUEVA CATEGORÍA:", producto.getCategoria());
                    float nuevoPrecio = Float.parseFloat(JOptionPane.showInputDialog("INGRESE NUEVO PRECIO:", producto.getPrecio()));
                    int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("INGRESE NUEVO STOCK:", producto.getStock()));

                    producto.setNombre(nuevoNombre);
                    producto.setCategoria(nuevaCategoria);
                    producto.setPrecio(nuevoPrecio);
                    producto.setStock(nuevoStock);

                    productosDao.actualizarProducto(producto);
                    JOptionPane.showMessageDialog(null, "PRODUCTO ACTUALIZADO EXITOSAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO");
                }
            }

            
            else if (opcion.equals("7")) {
                String nombreProveedor = JOptionPane.showInputDialog("INGRESE EL NOMBRE DEL PROVEEDOR:");
                Proveedores proveedor = proveedoresDao.buscarProveedor(nombreProveedor);
                if (proveedor != null) {
                    JOptionPane.showMessageDialog(null, proveedor.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "PROVEEDOR NO ENCONTRADO");
                }
            } 
            
            else if (opcion.equals("8")) {
                int newId = Integer.parseInt(JOptionPane.showInputDialog("INGRESE ID  DEL NUEVO PROVEEDOR:"));
                String nombre = JOptionPane.showInputDialog("INGRESE NOMBRE:");
                String contacto = JOptionPane.showInputDialog("INGRESE CONTACTO:");
                String direccion = JOptionPane.showInputDialog("INGRESE DIRECCIÓN:");
                proveedoresDao.anadirProveedor(new Proveedores(newId, nombre, contacto,direccion));
                JOptionPane.showMessageDialog(null, "PROVEEDOR AÑADIDO EXITOSAMENTE");
            } 
            
            else if (opcion.equals("9")) {
                String nombreProveedor = JOptionPane.showInputDialog("INGRESE EL NOMBRE DEL PROVEEDOR A ACTUALIZAR:");
                Proveedores proveedor = proveedoresDao.buscarProveedor(nombreProveedor);

                if (proveedor != null) {
                    String nuevoNombre = JOptionPane.showInputDialog("INGRESE NUEVO NOMBRE:", proveedor.getNombre());
                    String nuevoContacto = JOptionPane.showInputDialog("INGRESE NUEVO CONTACTO:", proveedor.getContacto());
                    String nuevaDireccion = JOptionPane.showInputDialog("INGRESE NUEVA DIRECCIÓN:", proveedor.getDireccion());

                    proveedor.setNombre(nuevoNombre);
                    proveedor.setContacto(nuevoContacto);
                    proveedor.setDireccion(nuevaDireccion);

                    proveedoresDao.actualizarProveedor(proveedor);
                    JOptionPane.showMessageDialog(null, "PROVEEDOR ACTUALIZADO EXITOSAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "PROVEEDOR NO ENCONTRADO");
                }
            }

            
            else if (opcion.equals("10")) {
                int idPedido = Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL ID DEL PEDIDO:"));
                Pedidos pedido = pedidoDao.buscarPedido(idPedido);
                if (pedido != null) {
                    JOptionPane.showMessageDialog(null, pedido.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "PEDIDO NO ENCONTRADO");
                }
            } 
            
            else if (opcion.equals("11")) {
            	int idCliente = 0;
                int newId = Integer.parseInt(JOptionPane.showInputDialog("INGRESE ID  DEL NUEVO PEDIDO:"));
                String fecha = JOptionPane.showInputDialog("FECHA PEDIDO:");
                String cliente = JOptionPane.showInputDialog("NOMBRE CLIENTE:");
                Float total = Float.parseFloat(JOptionPane.showInputDialog("TOTAL:"));
                
                Clientes c = clienteDao.buscarClienteNombre(cliente);
                
                if(c != null) {
                	
                	idCliente = c.getIdCliente();
                	
                }
                System.out.println(idCliente);
                pedidoDao.anadirPedido(new Pedidos(newId, fecha, c, total));
                JOptionPane.showMessageDialog(null, "PEDIDO AÑADIDO EXITOSAMENTE");
            } 
            
            else {
                JOptionPane.showMessageDialog(null, "OPCIÓN NO VÁLIDA");
            }
        }
    }
}
