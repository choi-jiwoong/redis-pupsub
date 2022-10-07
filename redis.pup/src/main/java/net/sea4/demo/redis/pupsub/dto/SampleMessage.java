package net.sea4.demo.redis.pupsub.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SampleMessage implements Serializable {

	private String roomId;
	private String name;
	private String message;
}
