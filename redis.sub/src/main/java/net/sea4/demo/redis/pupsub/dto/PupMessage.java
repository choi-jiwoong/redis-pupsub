package net.sea4.demo.redis.pupsub.dto;

import lombok.Data;

@Data
public class PupMessage {

	private String sender;

	private String context;

}
