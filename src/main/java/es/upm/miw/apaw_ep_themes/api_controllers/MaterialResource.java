package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.MaterialBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.MaterialDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Springboot注解(annotations)
//@ResponseBody表示该方法的返回结果直接写入HTTP response body中，一般在异步获取数据时使用，用于构建RESTful的api。
//在使用@RequestMapping后，返回值通常解析为跳转路径，加上@esponsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
//比如异步获取json数据，加上@Responsebody后，会直接返回json数据。该注解一般会配合@RequestMapping一起使用。

//@Controller：用于定义控制器类，在spring项目中由控制器负责将用户发来的URL请求转发到对应的服务接口（service层），
//一般这个注解在类中，通常方法需要配合注解@RequestMapping。

//@RestController：用于标注控制层组件(如struts中的action)，@ResponseBody和@Controller的合集。

//@RequestMapping：提供路由信息，负责URL到Controller中的具体函数的映射。
//@RequestMapping：@RequestMapping(“/path”)表示该控制器处理所有“/path”的UR L请求。
//RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。
//用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。该注解有六个属性：
//params:指定request中必须包含某些参数值是，才让该方法处理。
//headers:指定request中必须包含某些指定的header值，才能让该方法处理请求。
//value:指定请求的实际地址，指定的地址可以是URI Template 模式
//method:指定请求的method类型， GET、POST、PUT、DELETE等
//consumes:指定处理请求的提交内容类型（Content-Type），如application/json,text/html;
//produces:指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
@RestController
@RequestMapping(MaterialResource.MATERIALS)
public class MaterialResource {
    static final String MATERIALS = "/materials";
    static final String ID_ID = "/{id}";
    static final String NAME = "{name}";

    private MaterialBusinessController materialBusinessController;

    @Autowired
    public MaterialResource(MaterialBusinessController materialBusinessController) {
        this.materialBusinessController = materialBusinessController;
    }

    @PostMapping
    public MaterialDto create(@RequestBody MaterialDto materialDto) {
        materialDto.validate();
        return this.materialBusinessController.create(materialDto);
    }
    

    @DeleteMapping(value = ID_ID)
    public void delete(@PathVariable String id) {
        if (id == null) {
            throw new BadRequestException("Incomplete materialDto. ");
        }
        this.materialBusinessController.delete(id);
    }

    @PatchMapping(value = ID_ID)
    public void patch(@PathVariable String id, @RequestBody MaterialDto materialDto) {
        materialDto.validate();
        this.materialBusinessController.patch(id, materialDto);
    }


}
