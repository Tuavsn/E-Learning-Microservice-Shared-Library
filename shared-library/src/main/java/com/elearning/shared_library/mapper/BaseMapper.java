package com.elearning.shared_library.mapper;

import com.elearning.shared_library.dto.BaseDTO;
import com.elearning.shared_library.model.BaseEntityAudit;

import java.util.List;

public interface BaseMapper<Model extends BaseEntityAudit, DTO extends BaseDTO, ID> {
    DTO toDTO(Model model);

    Model toModel(DTO dto);

    List<DTO> toDTO(List<Model> model);

    List<Model> toModel(List<DTO> dto);
}
