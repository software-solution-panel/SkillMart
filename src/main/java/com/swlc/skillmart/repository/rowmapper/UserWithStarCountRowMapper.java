package com.swlc.skillmart.repository.rowmapper;

import com.swlc.skillmart.dto.UserWithStarCountDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserWithStarCountRowMapper implements RowMapper<UserWithStarCountDTO> {

    @Override
    public UserWithStarCountDTO mapRow(ResultSet rs, int row) throws SQLException {
        UserWithStarCountDTO dto = new UserWithStarCountDTO();
        dto.setId(rs.getString("id"));
        dto.setFirstName(rs.getString("first_name"));
        dto.setLastName(rs.getString("last_name"));
        dto.setAddress(rs.getString("address"));
        dto.setMobile(rs.getString("mobile"));
        dto.setAvailable(rs.getBoolean("available"));
        dto.setType(rs.getString("type"));
        dto.setServiceArea(rs.getString("service_area"));
        dto.setServiceType(rs.getString("service_type"));
        dto.setQualification(rs.getString("qualification"));
        dto.setLinks(rs.getString("links"));
        dto.setStars(rs.getInt("stars"));
        return dto;
    }

}

