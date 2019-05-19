package testing;

import java.util.Collection;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import testing.dao.EmpleadosService;
import testing.dto.Empleado;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
public class TestController {

    @RequestMapping("/")
    public Collection<Empleado> index() {
        EmpleadosService sEmpleado = new EmpleadosService();
        return sEmpleado.getEmpleados();
    }

}