package com.elearning.shared_library.mapper;

import com.elearning.shared_library.dto.BaseDTO;
import com.elearning.shared_library.model.BaseEntityAudit;

import java.util.List;
import java.util.UUID;

public interface BaseMapper<Model extends BaseEntityAudit, DTO extends BaseDTO, ID extends UUID> {
    DTO toDTO(Model model);

    Model toModel(DTO dto);

    List<DTO> toDTO(List<Model> model);

    List<Model> toModel(List<DTO> dto);
}
