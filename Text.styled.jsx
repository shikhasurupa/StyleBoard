import styled, { css } from "styled-components";
import { SIZES } from "./sizes";

export const Text = styled.p`
	font-size: ${(props) => SIZES[props.size] || SIZES["normal"]};
	color: ${(props) => props.color || props.theme.textColor};
	white-space: nowrap;
	font-weight: 600;


	&.logo {
		letter-spacing: -1px;
	}

	${({ colorType }) =>
		colorType === "pinterestColor" &&
		css`
			color: ${(props) => props.theme.pinterestColor};
		`}

	${({ colorType }) =>
		colorType === "signUpTextColor" &&
		css`
			color: ${(props) => props.theme.signUpTextColor};
		`}
`;