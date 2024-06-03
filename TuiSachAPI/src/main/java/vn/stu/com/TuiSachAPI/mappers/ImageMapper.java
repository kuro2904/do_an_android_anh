package vn.stu.com.TuiSachAPI.mappers;

import org.springframework.stereotype.Service;
import vn.stu.com.TuiSachAPI.dtos.ImageDTO;
import vn.stu.com.TuiSachAPI.entities.Image;

@Service
public class ImageMapper {

    public ImageDTO toDTO(Image image) {
        return new ImageDTO(image.getId(), image.getPath());
    }

}
